'use client';

import Image from 'next/image';
import { useRouter } from 'next/navigation';
import { getPhoto, Photo } from '@/lib/photos';
import { useLayoutEffect, useState } from 'react';

export default function Photo({
  params: { photoId },
}: {
  params: {
    photoId: string;
  };
  }) {
  const [photo, setPhoto] = useState<Photo>();
  useLayoutEffect(() => {
    (async function () {
      const data = await getPhoto(+photoId);
      setPhoto(data);
    })();
    
  }, [photoId]);
  
  const router = useRouter();
  const goList = () => {
    router.push('/photos');
  };
  return (
    <>
      <h1 className='text-2xl mt-5'>
        #{photo?.albumId} - {photo?.title}
      </h1>
      {photo && <Image
        onClick={goList}
        src={photo.url}
        alt={photo.title}
        width={600}
        height={600}
        loading='lazy'
        className='cursor-pointer'
      />}
      <h2 className='text-xl'>{photo?.title}</h2>
    </>
  );
}
