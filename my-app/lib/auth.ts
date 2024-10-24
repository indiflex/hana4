import crypto from 'crypto';
import NextAuth, { User } from 'next-auth';
import Credentials from 'next-auth/providers/credentials';
import GitHub from 'next-auth/providers/github';
import Google from 'next-auth/providers/google';

export const {
  handlers: { GET, POST },
  auth,
  signIn,
  signOut,
} = NextAuth({
  providers: [
    Credentials({
      name: '이메일',
      credentials: {
        email: {
          label: '이메일',
          type: 'email',
          placeholder: 'example@example.com',
        },
        passwd: { label: '패스', type: 'password' },
      },
      async authorize(credentials) {
        if (!credentials || !credentials.email || !credentials.passwd)
          return null;

        console.log('🚀  credentials:', credentials);
        const { email } = credentials;
        const user = {
          // id: hashPasswd(credentials.passwd.toString(), email.toString()),
          id: `${credentials.passwd}::myrecipe`,
          email,
          name: 'Hong',
          // name: hashPasswd(credentials.passwd.toString()),
        } as User;
        console.log('🚀  user:', user);
        return user;
      },
    }),
    Google,
    GitHub,
  ],
  callbacks: {
    async signIn({ user, account }) {
      const { name, email } = user;
      // console.log('🚀 signIn - user:', user);
      console.log(account?.provider, '🚀 signIn - account:', account);

      // select db...
      // if (alreadyRegist) return true;

      if (name && email)
        return `/register?${new URLSearchParams({ name, email }).toString()}`;
      return true;
    },
    async session({ session, token }) {
      // console.log('🚀 cb - session:', session);
      // console.log('🚀 cb - token:', token);
      // console.log('🚀 session - user:', user);
      if (token.sub?.endsWith('::myrecipe'))
        session.user.id = hashPasswd(token.sub, session.user.email);
      else session.user.id = token.sub || '';

      return session;
    },

    // async redirect({ url, baseUrl }) {
    //   const session = await auth();
    //   console.log('🚀 redirect>>', url, baseUrl, session);
    //   // return 'http://localhost:3000/todos';
    //   return baseUrl;
    // },
  },
  pages: {
    signIn: '/login',
  },
  trustHost: true,
});

function hashPasswd(passwd: string, email: string) {
  return (
    crypto.createHash('sha512').update(passwd).digest('base64') + '::' + email
  );
}
