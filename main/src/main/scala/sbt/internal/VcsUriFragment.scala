/*
 * sbt
 * Copyright 2023, Scala center
 * Copyright 2011 - 2022, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 * Licensed under Apache License 2.0 (see LICENSE)
 */

package sbt
package internal

private[sbt] object VcsUriFragment {

  def validate(fragment: String): Unit = {
    if (fragment == null)
      throw new IllegalArgumentException("VCS URI fragment must not be null")
    fragment.foreach { c =>
      if (c == '&' || c == '|' || c == ';')
        throw new IllegalArgumentException(
          "Invalid character in VCS URI fragment (shell metacharacters are not allowed)"
        )
      if (Character.isISOControl(c))
        throw new IllegalArgumentException(
          "Invalid character in VCS URI fragment (control characters are not allowed)"
        )
    }
  }
}
