import { USERS } from './users';

export function add(a: number, b: number) {
  return a + b;
}

export const promi = (delay: number) =>
  new Promise((resolve, reject) => {
    setTimeout(() => resolve(delay), delay);
  });

export const findUser = (userId: number) =>
  USERS.find(({ id }) => id === userId);
