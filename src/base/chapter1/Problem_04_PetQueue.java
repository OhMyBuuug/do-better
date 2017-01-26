package base.chapter1;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <br> Project: do-better
 * <br> Package: base.chapter1
 * <br> Description: 猫狗队列
 * <br> 题目: Pet,Dog,Cat类定义如下,实现一种猫狗队列的结构,要求如下:
 * <br> 用户可以调用add方法将cat类或者dog类的实例放入队列中;
 * <br> 用户可以抵用pollAll方法,将队列中所有的实例按照队列的先后顺序依次弹出;
 * <br> 用户可以调用pollDog方法,将队列中dog类的实例按照队列的先后顺序依次弹出;
 * <br> 用户可以调用pollCat方法,将队列中cat类的实例按照队列的先后顺序依次弹出;
 * <br> 用户可以调用isEmpty方法,检查队列中是否还有dog或cat的实例;
 * <br> 用户可以调用isDogEmpty方法,检查队列中是否还有dog的实例;
 * <br> 用户可以调用isCatEmpty方法,检查队列中是否有cat的实例;
 * <br> Date: Created in 17:10 2017/1/24.
 * <br> Modified By
 *
 * @author SiGen
 */
public class Problem_04_PetQueue {
    /**
     * Pet,Cat,Dog类定义如下
     */
    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    class Dog extends Pet {
        public Dog(String type) {
            super("Dog");
        }
    }

    class Cat extends Pet {
        public Cat(String type) {
            super("Cat");
        }
    }

    /**
     * Your code
     */
    class PetEnterQueue {
        private Pet pet;
        private int index;

        public PetEnterQueue(Pet pet, Integer index) {
            this.pet = pet;
            this.index = index;
        }

        public Pet getPet() {
            return this.pet;
        }

        public Integer getIndex() {
            return this.index;
        }

        public String getPetType() {
            return this.pet.getType();
        }
    }

    class PetQueue {
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private int count;

        public PetQueue() {
            this.dogQueue = new LinkedList<PetEnterQueue>();
            this.catQueue = new LinkedList<PetEnterQueue>();

            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getType().equals("Dog")) {
                dogQueue.add(new PetEnterQueue(pet, count++));
            } else if (pet.getType().equals("Cat")) {
                catQueue.add(new PetEnterQueue(pet, count++));
            } else {
                throw new RuntimeException("Wrong type");
            }
        }

        public Pet pollAll() {
            if (catQueue != null && dogQueue != null) {
                if (catQueue.peek().getIndex() < dogQueue.peek().getIndex()) {
                    return catQueue.poll().getPet();
                } else {
                    return dogQueue.poll().getPet();
                }
            } else if (!catQueue.isEmpty()) {
                return catQueue.poll().getPet();
            } else if (!dogQueue.isEmpty()) {
                return dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("Wrong type");
            }
        }

        public Pet getDog() {
            if (dogQueue.isEmpty()) {
                throw new RuntimeException("DogQueue is empty");
            } else {
                return dogQueue.poll().getPet();
            }
        }

        public Pet getCat() {
            if (catQueue.isEmpty()) {
                throw new RuntimeException("CatQueue is empty");
            } else {
                return catQueue.poll().getPet();
            }
        }

        public boolean isEmpty() {
            return dogQueue.isEmpty() && catQueue.isEmpty();
        }

        public boolean isDogEmpty() {
            return dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQueue.isEmpty();
        }
    }
}
