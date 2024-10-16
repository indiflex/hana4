'use client';

import { mySignOut } from '@/actions/myauth';
import { useSession } from 'next-auth/react';
import { useEffect, useState } from 'react';
import { Button } from './ui/button';

export default function SignInOut({
  whoami,
}: {
  whoami: () => Promise<string>;
}) {
  const { data: session } = useSession();
  const [name, setName] = useState('');

  useEffect(() => {
    (async function () {
      setName(await whoami());
    })();
  }, [whoami]);

  // if (session?.user)
  if (name)
    return (
      <>
        <a href='/api/auth/signout'>SignOut</a>
        <Button
          onClick={async () => {
            await mySignOut();
          }}
        >
          {name} OUT {session?.user?.name}
        </Button>
      </>
    );

  return <a href='/api/auth/signin'>SignIn</a>;
}
