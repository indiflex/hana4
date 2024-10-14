import { SessionProvider } from 'next-auth/react';
import { auth } from '@/lib/auth';
import SignInOut from './SingInOut';

export default async function Nav() {
  const session = await auth();
  return (
    <nav className='flex justify-around shadow mb-3'>
      <a href='/'>Home</a>
      <a href='/hello'>Hello</a>
      <a href='/hi'>Hi</a>
      <a href='/shop/aaa'>Shop</a>
      <a href='/parallel'>Parallel</a>
      <a href='/intercept'>Intercept</a>
      <a href='/todos'>Todos</a>
      <a href='/photos'>Photos</a>
      <a href='/books'>Books</a>
      <a href='/about'>About</a>
      <SessionProvider session={session}>
        <SignInOut />
      </SessionProvider>
    </nav>
  );
}
