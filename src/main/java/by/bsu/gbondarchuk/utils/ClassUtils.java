package by.bsu.gbondarchuk.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ClassUtils {

    public static final String CLASS_FILE_SUFFIX = ".class";

    public static Collection<Class> getAllClasses(Package p) {
        ClassLoader loader = ClassUtils.class.getClassLoader();

        File packageFile = getPackageFile(p, loader);

        Collection<File> files = getAllFiles(packageFile);
        Collection<File> classFiles = getClassFiles(files);
        Collection<Class> classes = new ArrayList<Class>();
        for (File classFile : classFiles) {
            try {
                StringBuilder classNameBuilder = new StringBuilder(classFile.getName());
                classNameBuilder
                        .delete(classNameBuilder.indexOf(CLASS_FILE_SUFFIX), classNameBuilder.length())
                        .insert(0, '.')
                        .insert(0, p.getName());
                classes.add(loader.loadClass(classNameBuilder.toString()));

            } catch (ClassNotFoundException e) {
                System.out.println("Could not found class");
                e.printStackTrace();
            }
        }
        return classes;
    }

    private static File getPackageFile(Package p, ClassLoader loader) {
        String path = p.getName().replaceAll("[.]", "/");
        File packageFile = null;
        try {
            Enumeration<URL> resources = loader.getResources(path);
            if (resources.hasMoreElements()) {
                packageFile = new File(resources.nextElement().getFile());
            }
        } catch (IOException e) {
            System.out.println("Could not load package resources");
            e.printStackTrace();
        }
        return packageFile;
    }

    public static Collection<File> getAllFiles(File base) {
        List<File> list = new ArrayList<File>();
        if (base == null || !base.exists() || base.isFile() || base.listFiles() == null) {
            return list;
        }
        List<File> filesAndDirs = new ArrayList<File>(Arrays.asList(base.listFiles()));
        for (int i = 0; i < filesAndDirs.size(); i++) {
            File file = filesAndDirs.get(i);
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                if (subFiles != null && subFiles.length > 0) {
                    filesAndDirs.addAll(Arrays.asList(subFiles));
                }
            } else {
                list.add(file);
            }
        }
        return list;
    }

    public static Collection<File> getClassFiles(Collection<File> files) {
        List<File> classes = new ArrayList<File>();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(CLASS_FILE_SUFFIX)) {
                classes.add(file);
            }
        }
        return classes;
    }
}
