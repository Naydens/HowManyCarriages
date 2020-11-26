package oop.HowManyCarriages;


public class Train {
    private Node first;
    private Node last;
    private Node current;
    private int size = 0;

    Train() {
        this.size = (int)(Math.random()*5)+2;
        for (int i = 0; i < size; i++) {
            Carriage carriage = new Carriage(Gen.randomLight());
            add(carriage);
        }
    }

    private void add(Carriage carriage) {
        if (first == null) {
            Node n = new Node();
            n.setCarriage(carriage);
            this.current = n;
            this.first = n;
            this.last = n;
            return;
        }
        Node n = new Node();
        n.setCarriage(carriage);
        this.last.setNext(n);
        n.setPrev(this.last);
        n.setNext(this.first);
        this.first.setPrev(n);
        this.last = n;
    }

    public Carriage next() {
        Carriage carriage=current.getCarriage();
        this.current = current.getNext();
        return carriage;
    }

    public Carriage previous() {
        this.current = current.getPrev();
        return this.current.getCarriage();
    }
    public int size(){
         return size;
    }
}
