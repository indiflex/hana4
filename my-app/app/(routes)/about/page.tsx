import { auth } from '@/lib/auth';
import AboutComp from '@/components/AboutCompo';

export default async function About() {
  const session = await auth();
  return (
    <>
      <h1>About Page</h1>
      <AboutComp session={session} />
    </>
  );
}
