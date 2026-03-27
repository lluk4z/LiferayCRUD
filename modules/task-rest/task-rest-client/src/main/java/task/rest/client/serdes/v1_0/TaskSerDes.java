package task.rest.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import task.rest.client.dto.v1_0.Task;
import task.rest.client.json.BaseJSONParser;

/**
 * @author me
 * @generated
 */
@Generated("")
public class TaskSerDes {

	public static Task toDTO(String json) {
		TaskJSONParser taskJSONParser = new TaskJSONParser();

		return taskJSONParser.parseToDTO(json);
	}

	public static Task[] toDTOs(String json) {
		TaskJSONParser taskJSONParser = new TaskJSONParser();

		return taskJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Task task) {
		if (task == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (task.getCompleted() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"completed\": ");

			sb.append(task.getCompleted());
		}

		if (task.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(task.getDescription()));

			sb.append("\"");
		}

		if (task.getTaskId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taskId\": ");

			sb.append(task.getTaskId());
		}

		if (task.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(task.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TaskJSONParser taskJSONParser = new TaskJSONParser();

		return taskJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Task task) {
		if (task == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (task.getCompleted() == null) {
			map.put("completed", null);
		}
		else {
			map.put("completed", String.valueOf(task.getCompleted()));
		}

		if (task.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(task.getDescription()));
		}

		if (task.getTaskId() == null) {
			map.put("taskId", null);
		}
		else {
			map.put("taskId", String.valueOf(task.getTaskId()));
		}

		if (task.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(task.getTitle()));
		}

		return map;
	}

	public static class TaskJSONParser extends BaseJSONParser<Task> {

		@Override
		protected Task createDTO() {
			return new Task();
		}

		@Override
		protected Task[] createDTOArray(int size) {
			return new Task[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "completed")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "taskId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				return false;
			}

			return false;
		}

		@Override
		protected void setField(
			Task task, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "completed")) {
				if (jsonParserFieldValue != null) {
					task.setCompleted((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					task.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "taskId")) {
				if (jsonParserFieldValue != null) {
					task.setTaskId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					task.setTitle((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			sb.append(_toJSON(value));

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _toJSON(Object value) {
		if (value == null) {
			return "null";
		}

		if (value instanceof Map) {
			return _toJSON((Map)value);
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			StringBuilder sb = new StringBuilder("[");

			Object[] values = (Object[])value;

			for (int i = 0; i < values.length; i++) {
				sb.append(_toJSON(values[i]));

				if ((i + 1) < values.length) {
					sb.append(", ");
				}
			}

			sb.append("]");

			return sb.toString();
		}

		if (value instanceof String) {
			return "\"" + _escape(value) + "\"";
		}

		return String.valueOf(value);
	}

}