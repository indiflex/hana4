import { getTodos } from '@/lib/todos';

export async function generateStaticParams() {
  return (await getTodos(1)).map(({ id }) => ({
    id: id.toString(),
  }));
  // return [{ id: '1' }, { id: '2' }];
}

export default async function AboutTodo({
  params: { id },
}: {
  params: { id: string };
}) {
  const todos = await getTodos(1);
  const todo = todos.find((td) => td.id === +id);
  if (!todo) {
    return <h1 className='text-2xl text-red-500'>#{id} is not found!!</h1>;
  }

  const { title, completed } = todo;

  return (
    <>
      <h1 className='text-2xl'>About Todo #{id}</h1>
      <strong className={`${completed ? 'line-through' : 'font-extrabold'}`}>
        {title}
      </strong>
    </>
  );
}
