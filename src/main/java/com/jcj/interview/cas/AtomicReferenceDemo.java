package com.jcj.interview.cas;

import lombok.*;

import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
class User{
    String username;
    int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 25);
        User l4 = new User("l4", 22);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get());

    }
}
