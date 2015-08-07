package org.spartan.refactoring.spartanizations;

import static org.spartan.utils.Utils.objects;

import java.io.File;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests that each directory in our test suite is a name of valid
 * {@link Spartanization} class.
 *
 * @author Yossi Gil
 * @since 2014/05/24
 */
@RunWith(Parameterized.class) //
public class SpartanizationClassForFolderExists extends FileTestUtils {
  /**
   * @return a collection of cases, where each case is an array of length 1
   *         containing the name of a in the test suite
   */
  @Parameters(name = "{index}: {0}") //
  public static Collection<Object[]> cases() {
    return new FileTestUtils.Directories() {
      @Override Object[] makeCase(final File folder) {
        return objects(folder.getName());
      }
    }.go();
  }
  /**
   * A name of a folder whose name should represent a {@link Spartanization}
   * class
   */
  @Parameter(value = 0) public String folderForClass;
  /**
   * Tests that {@link #folderForClass} is a valid class name
   */
  @Test public void validClassName() {
    makeSpartanizationObject(folderForClass);
  }
}