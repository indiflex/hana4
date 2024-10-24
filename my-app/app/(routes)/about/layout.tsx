import { User } from 'next-auth';
import Link from 'next/link';
import { PropsWithChildren, Suspense } from 'react';
import { auth } from '@/lib/auth';

type Usr = User & { passwd?: string };

export default async function AboutLayout({ children }: PropsWithChildren) {
  const session = await auth();
  // console.log('🚀  session:', session);
  const user = session?.user as Usr;

  return (
    <div className='border p-5'>
      <h1 className='text-2xl'>
        About Layout: {user?.name} - {user?.id}
      </h1>
      <a href='/about/me'>Me</a> | <a href='/about/1'>Todo#1</a>
      <div className='bg-purple-200 text-center mb-5'>
        <Suspense fallback={<h1>Loading...</h1>}>{children}</Suspense>
      </div>
      {session?.user ? (
        <Link href='/api/auth/signout?callbackUrl=/'>Log Out</Link>
      ) : (
        <Link href='/api/auth/signin'>Log In</Link>
      )}
    </div>
  );
}
