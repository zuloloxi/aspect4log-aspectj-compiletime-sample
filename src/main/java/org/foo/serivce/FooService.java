package org.foo.serivce;

import static net.sf.aspect4log.Log.Level.ERROR;
import static net.sf.aspect4log.Log.Level.INFO;
import static net.sf.aspect4log.Log.Level.TRACE;
import static net.sf.aspect4log.Log.Level.WARN;

import java.util.regex.Pattern;

import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Exceptions;

@Log
public class FooService {
	public enum Gender {
		MALE, FEMALE
	}

	public FooService(String foo) {
	}

	private FooDao dao = new FooDao();

	public String helloDefaultLogging(String name, Gender gender) {
		name = createGreeting(name, gender);
		dao.find(name);
		dao.saveOrUpdate(name);
		return name;

	}

	@Log(enterLevel = TRACE, exitLevel = INFO, on = @Exceptions(level = WARN))
	public String helloCustomizedLogLevel(String name, Gender gender) {
		return createGreeting(name, gender);
	}

	@Log(on = { @Exceptions(exceptions = IllegalArgumentException.class, level = WARN, stackTrace = false), @Exceptions(level = ERROR) })
	public String helloDifferentLogLevelForExceptions(String name, Gender gender) {
		return createGreeting(name, gender);
	}

	@Log(argumentsTemplate = "name=${args[0]}", resultTemplate = "${result}")
	public String helloCustomizedTemplate(String name, Gender gender) {
		return createGreeting(name, gender);
	}

	@Log(mdcKey = "userName", mdcTemplate = "${args[0]}")
	public String helloMdc(String name, Gender gender) {
		return createGreeting(name, gender);
	}

	@Log(mdcKey = "userName", mdcTemplate = "${args[0]}")
	public String helloIdent(String name, Gender gender) {
		return createGreeting(name, gender);
	}

	
	@Log(on = { @Exceptions(exceptions = RuntimeException.class, level = WARN, stackTrace = false), @Exceptions(level = WARN) })
	private String createGreeting(String name, Gender gender) {
		checkValidName(name);
		if (gender == Gender.MALE) {
			return "Hello Mr. " + name;
		} else {
			return "Hello Mrs. " + name;
		}
	}

	// starts with letter, has at least one space
	// (?=\w+ )^\w[\w ]*\w$
	private static final Pattern sillyNamePattern = Pattern.compile("(?=\\w+ )^\\w[\\w ]*\\w$", Pattern.CASE_INSENSITIVE);

	@Log(on = { @Exceptions(exceptions = RuntimeException.class, level = WARN, stackTrace = false), @Exceptions(level = WARN) })
	private void checkValidName(String name) {
		if (name == null) {
			throw new NullPointerException("name must not be null");
		}
		if (!sillyNamePattern.matcher(name).matches()) {
			throw new IllegalArgumentException(name + " - is not a propper name.");
		}
	}
}
