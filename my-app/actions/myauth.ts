'use server';

import { AuthError } from 'next-auth';
import { signIn, signOut } from '@/lib/auth';

export { signIn as mySignIn, signOut as mySignOut };

export async function logIn(provider: 'google' | 'github') {
  await signIn(provider, { redirectTo: '/' });
}

export async function authenticate(
  prevState: string | undefined,
  formData: FormData
) {
  const email = formData.get('email');
  const passwd = formData.get('passwd');
  if (!email || !passwd) return 'Input the email & passwd, plz';

  try {
    await signIn('credentials', formData);
  } catch (error) {
    if (error instanceof AuthError) {
      switch (error.type) {
        case 'EmailSignInError':
          return error.message;
        case 'CredentialsSignin':
          return 'Invalid Credentials!';
        default:
          return 'Something went wrong!';
      }
    }
    throw error;
  }
}
