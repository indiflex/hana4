import { auth } from '@/lib/auth';

export default async function Error() {
  const session = await auth();
  console.log('🚀  session:', session);
  return (
    <>
      <h1 className='text-2xl'>My Auth Error!!</h1>
      <div>session: {session?.user?.email}</div>
    </>
  );
}
