package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

   protected SingleLinkedListNode<T> head;

   public SingleLinkedListImpl() {
      this.head = new SingleLinkedListNode<T>();
   }

   @Override
   public boolean isEmpty() {
      return head.isNIL();
   }

   @Override
   public int size() {
      if (this.isEmpty()) {
         return 0;
      }

      int cont = 1;
      SingleLinkedListNode<T> aux = head.getNext();

      while (!aux.isNIL()) {
         cont++;
         aux = aux.getNext();
      }

      return cont;
   }

   @Override
   public T search(T element) {
      if (this.isEmpty()) {
         return null;
      }

      T resp = null;
      SingleLinkedListNode<T> aux = head;

      while (!aux.isNIL() || resp.equals(null)) {
         if (aux.getData().equals(element)) {
            resp = element;
         }
         aux = aux.getNext();
      }

      return resp;

   }

   @Override
   public void insert(T element) {
      SingleLinkedListNode<T> inserted = new SingleLinkedListNode<T>(element, null);

      if (this.isEmpty()) {
         this.setHead(inserted);
      } else {
         SingleLinkedListNode<T> aux = head;

         while (!aux.equals(inserted)) {
            if (aux.getNext().isNIL()) {
               aux.setNext(inserted);
            }
            aux = aux.getNext();
         }

      }

   }

   @Override
   public void remove(T element) {
      if (!this.isEmpty()) {
         SingleLinkedListNode<T> removed = new SingleLinkedListNode<T>(this.search(element), null);

         if (!removed.isNIL()) {
            if (head.equals(removed)) {
               this.setHead(head.getNext());
            } else {
               boolean condition = true;
               SingleLinkedListNode<T> aux = head;

               while (condition) {
                  if (aux.getNext().equals(removed)) {
                     aux.setNext(aux.getNext().getNext());
                     condition = false;
                  } else {
                     aux = aux.getNext();
                  }
               }
            }
         }
      }
   }

   @Override
   public T[] toArray() {
      T[] resp = (T[]) new Object[this.size()];
      SingleLinkedListNode<T> aux = head;

      for (int i = 0; i < resp.length; i++) {
         resp[i] = aux.getData();
         aux = aux.getNext();
      }

      return resp;
   }

   public SingleLinkedListNode<T> getHead() {
      return head;
   }

   public void setHead(SingleLinkedListNode<T> head) {
      this.head = head;
   }

}
