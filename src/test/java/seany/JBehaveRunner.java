package seany;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public class JBehaveRunner extends JUnitStories {
    public JBehaveRunner() {
        super();
    }

    protected List<String> storyPaths() {
        return Arrays.asList("stories/bmi.story", "stories/add.story");
    }


    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.
                        getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.HTML,
                                        Format.CONSOLE)
                                .withRelativeDirectory
                                        ("jbehave-report")
                );
    }

    @Override
    public List candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        System.out.println("a!!!");

        return new InstanceStepsFactory( configuration(),
                 new BMI() );
    }

//    @Override
//    protected List<String> storyPaths() {
//        return Collections.singletonList("stories/bmi.story");
//    }
}