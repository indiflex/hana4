const students = [
  '강능요',
  '강재준',
  '길유정',
  '조민석',
  '김도희',
  '김미진',
  '김인선',
  '강민관',
  '김예나',
  '김현수',
  '문해빈',
  '남승혁',
  '남인우',
  '김민서',
  '최강희',
  '김은서',
  '문규빈',
  '장다연',
  '정성엽',
  '박준용',
  '이규호',
  '문서아',
  '박시온',
  '정성현',
  '조경은',
  '조서현',
  '임형석',
  '천혜민',
];
const inps = document.getElementsByTagName('input');
console.log('***********', inps);

// const seats = [...inps].filter(inp => !inp.value);
// console.log('🚀  seats:', seats);
// for (let i = 0; i < students.length; i++) seats[i].value = students[i];

function set(student) {
  const seats = [...inps].filter(inp => !inp.value);
  // console.log('🚀  seats:', seats.length);
  const seat = Math.floor(Math.random() * seats.length);
  // console.log('🚀  seat:', seat);
  seats[seat].value = student;
}

function start() {
  let idx = 0;
  const intl = setInterval(() => {
    set(students[idx++]);
    if (idx >= students.length) clearInterval(intl);
  }, 800);
}
