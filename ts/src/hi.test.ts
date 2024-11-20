import { add, findUser, promi } from './hi';

describe('hi - ', () => {
  beforeEach(() => {
    // console.log('before!!');
  });

  afterEach(() => {
    // console.log('after!!');
  });

  test('add', () => {
    const sum = add(1, 2);
    expect(sum).toBeCloseTo(3);
    expect(add(10, -2)).toBe(8);
  });

  test('promi', done => {
    promi(500).then(ret => {
      expect(ret).toBe(500);
      done();
    });
  });

  test('findUser', () => {
    expect(findUser(2)).toEqual({ id: 2, name: 'Kim' });
  });
});
