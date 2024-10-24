'use client';

import { Session } from 'next-auth';
// import { useSession } from 'next-auth/react';
import { useEffect } from 'react';

export default function AboutComp({ session }: { session: Session | null }) {
  // const { data: session } = useSession();

  useEffect(() => {
    console.log('***************>>>', session?.user);
  }, [session?.user]);

  return (
    <>
      <strong>userId: {session?.user?.id}</strong>
    </>
  );
}
