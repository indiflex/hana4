'use client';

import { getSession, mySignOut } from '@/actions/myauth';
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
      // setName(await whoami());
      const ss = await getSession();
      setName(ss?.user?.name || '');
    })();
  }, [whoami]);

  // if (session?.user)
  if (name)
    return (
      <>
        <a href='/api/auth/signout'>SignOut</a>
        <Button
          onClick={async () => {
            await mySignOut({ redirectTo: '/about' });
          }}
        >
          {name} OUT {session?.user?.name}
        </Button>
        <Button
          onClick={async () => {
            const ss = await getSession();
            console.log('🚀  ss:', ss);
          }}
        >
          OOO
        </Button>
      </>
    );

  return <a href='/login'>SignIn</a>;
}
