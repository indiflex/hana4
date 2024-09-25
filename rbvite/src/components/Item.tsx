import { FaTrashCan } from 'react-icons/fa6';
import { useSession, type CartItem } from '../hooks/session-context';
import { FormEvent, useRef, useState } from 'react';
import { useCounter } from '../hooks/counter-hook';
import Button from './atoms/Button';
import { FaRedo, FaSave } from 'react-icons/fa';

type Props = {
  item: CartItem;
  toggleAdding?: () => void;
};

export default function Item({ item, toggleAdding }: Props) {
  const { id, name, price } = item;

  const { removeCartItem, addCartItem, editCartItem } = useSession();
  const { plusCount } = useCounter();
  const [isEditing, setIsEditing] = useState(!id);
  const nameRef = useRef<HTMLInputElement>(null);
  const priceRef = useRef<HTMLInputElement>(null);

  const toggleEditing = () => {
    if (toggleAdding) toggleAdding();
    else setIsEditing((pre) => !pre);

    plusCount();
  };

  const removeItem = (id: number) => {
    if (confirm('Are u sure?')) {
      removeCartItem(id);
    }
  };

  const saveItem = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const name = nameRef.current?.value;
    const price = priceRef.current?.value;
    // console.log('🚀  name/price:', name, price);
    if (!name) {
      alert('상품명을 입력하세요!');
      return nameRef.current?.focus();
    } else if (!price) {
      alert('금액을 입력하세요!');
      return priceRef.current?.focus();
    }

    if (id === 0) addCartItem(name, +price);
    else editCartItem({ id, name, price: +price });

    nameRef.current.value = '';
    priceRef.current.value = '';
    nameRef.current.focus();

    toggleEditing();
  };

  return (
    <>
      {isEditing ? (
        <form onSubmit={saveItem} className='mt-3 flex gap-3'>
          <small className='text-gray-300'>{id}</small>
          <input
            ref={nameRef}
            type='text'
            placeholder='name..'
            defaultValue={name}
            className='inp'
          />
          <input
            ref={priceRef}
            type='number'
            placeholder='price..'
            defaultValue={price}
            className='inp'
          />
          <Button type='reset' onClick={toggleEditing}>
            <FaRedo />
          </Button>
          <Button type='submit' variant='btn-primary'>
            <FaSave />
          </Button>
        </form>
      ) : (
        <a
          href='#'
          onClick={toggleEditing}
          className='group flex justify-between hover:bg-gray-200'
        >
          <strong className='group-hover:text-blue-500'>
            <small className='text-gray-200'>{id}</small> {name}
            <small className='ml-2 font-light text-gray-500 group-hover:text-gray-100'>
              {price.toLocaleString()}원
            </small>
          </strong>
          <button
            onClick={() => removeItem(id)}
            className='btn btn-danger px-1 py-0'
          >
            <FaTrashCan />
          </button>
        </a>
      )}
    </>
  );
}
