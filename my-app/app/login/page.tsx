'use client';

import { authenticate, logIn } from '@/actions/myauth';
import { useFormState, useFormStatus } from 'react-dom';
import EmailLogin from '@/components/EmailLogin';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';

export default function Login() {
  const [errorMsg, dispatchLogin] = useFormState(authenticate, undefined);

  return (
    <>
      <h1 className='text-2xl'>Login</h1>
      <form action={dispatchLogin} className='space-y-3'>
        <input type='hidden' name='redirectTo' value='/hello' />
        <Input name='email' placeholder='sample@aaa.com' />
        <Input type='password' name='passwd' placeholder='password...' />
        <LoginButton />
        <div className='text-red-600'>{errorMsg}</div>
      </form>

      <hr className='h-10' />

      <EmailLogin redirectTo='/about' />

      <div className='flex gap-5'>
        <Button onClick={() => logIn('google')}>Google</Button>
        <Button onClick={() => logIn('github')}>Github</Button>
      </div>
    </>
  );
}

function LoginButton() {
  const { pending } = useFormStatus();
  return <Button disabled={pending}>Login</Button>;
}
