# Laboratorio 1 AREP
  Este repo fue desarrollado como laboratorio de la clase AREP de la Escuela Colombiana de Ingenieria Julio Garavito.

- Se creo una Linkedlist propia de elementos tipo double que pudiera completar las siguientes operaciones:
````
	1. adicionar
  	2. remover
  	3. calcular su tamaño
  	4. saber si esta vacia
  	5. calcular su media
  	6. calcular su desviacion estandar

````

# Example
  ```
 // Insert the object o at the end of the list
    public boolean add(double o) {
        if(head.next == null && head.data == 0){
            head.data = o;
            total += o;
            tail = head;
            System.out.println("node: [ data: " + tail.data + ",prior: "+ tail.prior +"]");
            head.index = size;
            size++;
            return true;
        }else{
            Node addo = new Node(o, tail);
            tail.next = addo;
            total += o;
            tail = addo;
            System.out.println("node: [ data: " + tail.data + ",prior: "+ tail.prior.data +"]");
            tail.index = size;
            size++;
            return true;
        }    
  ```
  
- Adicionalmente se creo una prueba para cada operacion en una clase tipo Junit.
  ```
  @Test
    public void shouldSolveMeanFirstColumn()
    {
        MyMeanStandardLinkedList list = new MyMeanStandardLinkedList();
        list.add(160);
        list.add(591);
        list.add(114);
        list.add(229);
        list.add(230);
        list.add(270);
        list.add(128);
        list.add(1657);
        list.add(624);
        list.add(1503);
        double mean = list.calcMean();

        assertTrue( mean == 550.0 );
    }
  ```
  
# Getting Started
## Install with

```
git clone https://github.com/dracken1/CalcuComplejosCNYT.git
```

## Run with

Dentro de la carpeta AREP_LAB1, inice cmd e intrduzca los siguientes comandos:

```
mvn clean

mvn compile

mvn test
```

o tabmien:

```
mvn package
```

# Build with
El proyecto se desarrollo usando el lenguaje Java y la herramienta Intellij.

# Author
Nicolás Cárdenas Chaparro

# License
````
Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
````

# Acknowlegdments
- Practicing java
- Inspiration
