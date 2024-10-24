'use client';

import { authenticate, logIn } from '@/actions/myauth';
import { useFormState, useFormStatus } from 'react-dom';
import { useRef } from 'react';
import EmailLogin from '@/components/EmailLogin';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';

export default function Login() {
  const [errorMsg, dispatchLogin] = useFormState(authenticate, undefined);

  const emailRef = useRef<HTMLInputElement>(null);
  const passwdRef = useRef<HTMLInputElement>(null);

  // const submit = (e: FormEvent<HTMLFormElement>) => {
  const submit = () => {
    // e.preventDefault();
    const email = emailRef.current?.value || '';
    const passwd = passwdRef.current?.value || '';
    alert(email + passwd);
  };

  return (
    <>
      <h1 className='text-2xl'>Login</h1>
      <form action={dispatchLogin} onSubmit={submit} className='space-y-3'>
        <input type='hidden' name='redirectTo' value='/about' />
        <Input ref={emailRef} name='email' placeholder='sample@aaa.com' />
        <Input
          ref={passwdRef}
          type='password'
          name='passwd'
          placeholder='password...'
        />
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
