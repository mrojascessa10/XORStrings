run:Main.class
	java XORStrings $(ARGS)

Main.class: XORStrings.java
	javac XORStrings.java

clean:
	rm XORStrings.class
