function getDiffMillis(dt1, dt2) {
  const { getTime: getTime1 } = new Date(dt1);
  const { getTime: getTime2 } = new Date(dt2);
  return getTime1() - getTime2();
}
getDiffMillis('2021-01-01', '2021-01-02');
