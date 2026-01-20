package studyMyself.methods.level1.level5;

public class checkingMemory {
    // private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        // TODO change back to MB
        return bytes;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        // Calculate the used memory before a specific code segment
        long beforeUsedMem = runtime.totalMemory() - runtime.freeMemory();

        // CODE
        grades.run();

        runtime.gc();

        // Calculate the used memory after the specific code segment
        long afterUsedMem = runtime.totalMemory() - runtime.freeMemory();

        long actualMemUsedBySegment = afterUsedMem - beforeUsedMem;

        System.out.println("Total memory available to JVM: " + bytesToMegabytes(runtime.totalMemory()) + " MB");
        System.out.println("Initial used memory: " + bytesToMegabytes(beforeUsedMem) + " MB");
        System.out.println("Used memory after code segment: " + bytesToMegabytes(afterUsedMem) + " MB");
        System.out.println("Memory consumed by the code segment: " + bytesToMegabytes(actualMemUsedBySegment) + " MB");

    }

}
