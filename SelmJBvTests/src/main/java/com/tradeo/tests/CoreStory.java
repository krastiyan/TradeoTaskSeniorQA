package main.java.com.tradeo.tests;

//import static org.jbehave.core.reporters.Format.CONSOLE;
//import static org.jbehave.core.reporters.Format.HTML;
//import static org.jbehave.core.reporters.Format.TXT;
//import static org.jbehave.core.reporters.Format.XML;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Copied from JBehave tutorials and examples and modified for suit this project
 * needs</br>
 * At class bottom are left several tries to configure WebDriver instance to run
 * tests: CHromeDriver and FirefoxDriver.</br>
 * User is advised to check carefully Selenium and JBehave online documentation
 * AND examples, since they are not very well synchronized.</br>
 * Some JBehave documentation follows:</br>
 * <p>
 * Example of how to run a single story via JUnit. JUnitStory is a simple facade
 * around the Embedder. The user need only provide the configuration and the
 * CandidateSteps. Using this paradigm (which is the analogous to the one used
 * in JBehave 2) each story class must extends this class and maps one-to-one to
 * a textual story via the configured {@link StoryPathResolver}.
 * </p>
 * <p>
 * Users wanting to run multiple stories via the same Java class (new to JBehave
 * 3) should look at {@link TraderStories}, {@link CoreStoryRunner} or
 * {@link TraderAnnotatedEmbedderRunner}
 * </p>
 */
public abstract class CoreStory extends JUnitStory {

	public CoreStory() {
		configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
				.doIgnoreFailureInView(false).useThreads(1).useStoryTimeoutInSecs(Long.parseLong("60"));
	}

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		// Start from default ParameterConverters instance
		ParameterConverters parameterConverters = new ParameterConverters();
		// factory to allow parameter conversion and loading from external
		// resources (used by StoryParser too)
		ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
				new LoadFromClasspath(embeddableClass), parameterConverters, new TableTransformers());
		// add custom converters
		parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
				new ExamplesTableConverter(examplesTableFactory));

		return new MostUsefulConfiguration()
				.useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
				.usePendingStepStrategy(new FailingUponPendingStep())
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryParser(new RegexStoryParser(examplesTableFactory))
				.useStoryPathResolver(new UnderscoredCamelCaseResolver())
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT))
				.useParameterConverters(parameterConverters);// end of return
																// expression
	}

	/**
	 * ScanningStepsFactory used to enable flexible discovery of steps
	 * implementations.
	 */
	@Override
	public InjectableStepsFactory stepsFactory() {

		return new ScanningStepsFactory(configuration(), "main.java.com.tradeo.tests.steps"// the
																							// package
																							// to
																							// search
																							// in
																							// for
																							// steps
																							// implementations
		);
	}

	/// **
	// * FirefoxWebdriver try
	// * Below code might be useful for healthy FIrefox instance on computer
	/// running the tests.
	// * Author's Firefox instance state has been found corrupted or instance
	/// was too new to be supported by current libs versions.
	// */
	// private WebDriver driver;
	//
	// @Before
	// public void startWebdriver(){
	// driver = new FirefoxDriver();
	// TrTConfiguration.set(Constants.DRIVER, driver);
	// }

	// ChromeWebdriver try
	/**
	 * Static service instance is initialized below before this abstract
	 * class.</br>
	 * That is effectively initializing the service before each story gets
	 * executed.
	 */
	private static ChromeDriverService service;

	/**
	 * Object scope driver gets initialized below before each test executed by
	 * story.
	 */
	private WebDriver driver;

	@BeforeClass
	public static void createAndStartService() {
		// TODO: Implement using relative path to ChromeDriver executable!
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

		service = new ChromeDriverService.Builder()
				// .usingChromeDriverExecutable(new
				// File((String)System.getProperty("webdriver.chrome.driver")))
				.usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver"))).usingAnyFreePort()
				.build();
		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e);
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		TradeoTestsConfiguration.set(Constants.DRIVER, driver);
	}

	@After
	public void quitDriver() {
		driver.quit();
	}
	// Above ChromeWebdriver try found in Selenium's tutorials.
	// Important was to realize which ChromeDriver version is suitable for
	// Author's computer - 2.21 works OK, while latest 2.22 returns error.
	// Reason: Author's computer runs on Windows XP

}
