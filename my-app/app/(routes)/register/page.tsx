import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';

export default function Register({
  searchParams: { name, email },
}: {
  searchParams: { name: string; email: string };
}) {
  return (
    <>
      <h1 className='text-2xl'>Register</h1>
      <form className='flex flex-col gap-5 mt-5 w-96'>
        <Input defaultValue={name} type='text' />
        <Input defaultValue={email} type='email' />
        <Input type='password' placeholder='password...' />
        <Input type='tel' placeholder='010-0000-0000' />
        <Button>Regist</Button>
      </form>
    </>
  );
}
