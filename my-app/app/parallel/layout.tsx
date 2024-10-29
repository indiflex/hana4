import Link from 'next/link';
import { ReactNode } from 'react';
import { auth } from '@/lib/auth';

export default async function ParallelLayout({
  children,
  login,
  profile,
}: {
  children: ReactNode;
  login: ReactNode;
  profile: ReactNode;
}) {
  const didLogin = await auth();
  return (
    <>
      <h1 className='text-2xl'>Parallel Layout</h1>
      <Link href='/parallel/aaa'>Login/AAA</Link>
      <Link href='/parallel/bbb'>Profile/BBB</Link>
      {didLogin ? (
        <div className='flex justify-between gap-3 border p-5'>
          <div className='bg-purple-200'>{login}</div>
          <div className='bg-slate-200'>{profile}</div>
        </div>
      ) : (
        <div className='bg-purple-200'>{login}</div>
      )}
      <hr className='my-3 bg-slate-300' />
      {children}
    </>
  );
}
