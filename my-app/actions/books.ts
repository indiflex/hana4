'use server';

import { Book, books } from '@/app/api/books/bookdata';
import { redirect } from 'next/navigation';

export const getBook = (bookId: number) =>
  books.find(({ id }) => id === +bookId) as Book;

export const delBook = async (bookId: number) => {
  const idx = books.findIndex((book) => book.id === +bookId);
  if (idx === -1) return Response.json({ code: 404, message: 'Not Found' });

  books.splice(idx, 1);
  redirect('/books');
};

export const save = (bookId: number, title: string, writer: string) => {
  const book = books.find((book) => book.id === bookId);
  if (!book) return Response.json({ code: 404, message: 'Not Found' });

  book.title = title;
  book.writer = writer;

  return book;
};
