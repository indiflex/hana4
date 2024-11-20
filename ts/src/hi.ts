export function add(a: number, b: number) {
  return a + b;
}

export const promi = (delay: number) =>
  new Promise((resolve, reject) => {
    setTimeout(() => resolve(delay), delay);
  });

const USERS = [
  { id: 1, name: 'Hong' },
  { id: 2, name: 'Kim' },
];

export const findUser = (userId: number) =>
  USERS.find(({ id }) => id === userId);
