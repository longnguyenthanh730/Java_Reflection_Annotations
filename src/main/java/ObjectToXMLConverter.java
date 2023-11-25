import java.lang.reflect.Field;

public class ObjectToXMLConverter {
	
	    public static <T> String convertToXML(T obj) {
	        StringBuilder xml = new StringBuilder();
	        Class<?> clazz = obj.getClass();

	        xml.append("<").append(clazz.getSimpleName()).append(">\n");

	        for (Field field : clazz.getDeclaredFields()) {
	            field.setAccessible(true);
	            if (field.isAnnotationPresent(XMLElement.class)) {
	                try {
	                    Object value = field.get(obj);
	                    String fieldName = field.getAnnotation(XMLElement.class).name();
	                    xml.append("\t<").append(fieldName).append(">").append(value).append("</").append(fieldName).append(">\n");
	                } catch (IllegalAccessException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                
	                if (!field.getType().isPrimitive() && field.getAnnotation(XMLElement.class) == null) {
	                    try {
	                        Object nestedObject = field.get(obj);
	                        if (nestedObject != null) {
	                            xml.append(convertToXML(nestedObject));
	                        }
	                    } catch (IllegalAccessException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }

	        xml.append("</").append(clazz.getSimpleName()).append(">\n");
	        return xml.toString();
	    }
     
}