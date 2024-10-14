'use client';

import { useSession } from 'next-auth/react';

export default function SignInOut() {
  const { data: session } = useSession();

  if (session?.user) return <a href='/api/auth/signout'>SignOut</a>;

  return <a href='/api/auth/signin'>SignIn</a>;
}
