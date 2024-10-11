'use client';

import Link from 'next/link';
import { ReactNode, useLayoutEffect, useState } from 'react';
import { Input } from '@/components/ui/input';
import { type Book } from '../api/books/bookdata';

export default function BooksLayout({ children }: { children: ReactNode }) {
  const [books, setBooks] = useState<Book[]>();
  const [searchStr, setSearchStr] = useState('');

  useLayoutEffect(() => {
    (async function () {
      const books = (await fetch('http://localhost:3000/api/books').then(
        (res) => res.json
      )) as Book[];
      setBooks(books);
    })();
  });

  const search = () => {};

  return (
    <>
      <h1 className='text-2xl'>My Book Case</h1>

      <Input onChange={search} placeholder='title or writer...' />
      <ul className='x'>
        {books?.map(({ id, title }) => (
          <li key={id}>
            <Link href={`/books/${id}`}>{title}</Link>
          </li>
        ))}
      </ul>
    </>
  );
}
