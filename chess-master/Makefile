TARGET=Chess
SRC_DIR = src

all: compile
	java ${TARGET}

compile: 
	javac $(SRC_DIR)/${TARGET}.java

clean:
	rm *.class Pieces/*.class ${TARGET}.jar

jar: compile
	jar cfe ${TARGET}.jar ${TARGET} *.class Pieces/*.class Sprites/*.png
