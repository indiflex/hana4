import { NextRequest } from 'next/server';

export function GET(req: NextRequest) {
  const { searchParams } = req.nextUrl;
  console.log('qqqqqq>>>', searchParams.get('q'));
  const searchStr = searchParams.get('searchStr');
  const error = searchParams.get('error');
  return Response.json({ searchStr, error });
}

export async function POST(req: Request) {
  const body = await req.json();
  console.log('🚀  body:', body);

  return body;
}
