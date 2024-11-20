import { addUsers, deleteUsers, getUsers, updateUsers, USERS } from './users';

const OK = { message: 'OK' };

describe('/users', () => {
  test('get - users', async () => {
    const users = await getUsers();
    expect(users).toEqual(USERS);
  });

  test('post - users', async () => {
    const res = await addUsers('Lee');
    expect(res).toHaveProperty('id');
    expect(res).toHaveProperty('message', 'OK');
  });

  test('get - users', async () => {
    const users = await getUsers();
    expect(users).toHaveLength(3);
  });

  test('patch - users', async () => {
    expect(await updateUsers(2, 'KIM22')).toEqual(OK);
  });

  test('get - users', async () => {
    const users = await getUsers();
    const user = users.find(({ id }) => id === 2);
    expect(user).toEqual({ id: 2, name: 'KIM22' });
  });

  test('delete - users', async () => {
    expect(await deleteUsers(2)).toEqual(OK);
  });

  test('get - users', async () => {
    const users = await getUsers();
    expect(users).toHaveLength(2);
  });
});
