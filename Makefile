JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
		  Application.java \
		  Account.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
