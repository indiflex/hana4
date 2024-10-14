import assert from 'assert';

const ㄱ = 'ㄱ'.charCodeAt();
const ㅎ = 'ㅎ'.charCodeAt();
const 가 = '가'.charCodeAt();
const 힣 = '힣'.charCodeAt();
const 자음알파벳숫자 = [...'LMNRlmnr136780'].map(a => a.charCodeAt());

export function isEndJaum(str) {
  const s = str.charCodeAt(str.length - 1);
  return (
    (s >= ㄱ && s <= ㅎ) ||
    자음알파벳숫자.includes(s) ||
    (s >= 가 && s <= 힣 && (s - 가) % 28 !== 0)
  );
}

const josa = (str, ja_mo) => {
  const [ja, mo] = ja_mo.split('/');
  return isEndJaum(str) ? ja : mo;
};

const iga = str => josa(str, '이/가');
const eunun = str => josa(str, '은/는');
const eulul = str => josa(str, '을/를');
const eyuya = str => josa(str, '이어야/여야');
const rang = str => josa(str, '이랑/랑');

function testing() {
  assert.equal(`고성군${iga('고성군')}`, '고성군이');
  assert.equal(`고성군${eunun('고성군')}`, '고성군은');
  assert.equal(`고성군${eulul('고성군')}`, '고성군을');
  assert.equal(`성동구${iga('성동구')}`, '성동구가');
  assert.equal(`성동구${eunun('성동구')}`, '성동구는');
  assert.equal(`성동구${eulul('성동구')}`, '성동구를');

  assert.equal(`고성군${eyuya('고성군')}`, '고성군이어야');
  assert.equal(`성동구${eyuya('성동구')}`, '성동구여야');
}
// testing();

export { iga, josa, eunun, eulul, eyuya, rang };
