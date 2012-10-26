package wcs.scala
import wcs.java.{ Setup => JSetup }
import wcs.java.{ Site => JSite }
import wcs.java.{ CSElement => JCSElement }
import wcs.java.{ Template => JTemplate }
import wcs.java.{ SiteEntry => JSiteEntry }

/**
 * Setup wrapper in Scala
 */
abstract class Setup extends JSetup {

  class Asset

  case class Site(id: Long, name: String, description: String, types: Array[String], users: Array[String], roles: Array[String]) extends Asset

  case class CSElement(id: Long, name: String, description: String, element: String) extends Asset

  case class Template(id: Long, name: String, description: String, element: String, cscache: String = "true, ~0", sscache: String = "true,~0") extends Asset

  case class SiteEntry(id: Long, name: String, description: String, element: String, wrapper: Boolean = false) extends Asset

  def site: Site

  def assets: List[Asset]

  override def getSite = new JSite(site.id, site.name, site.description, site.types, site.users, site.roles)

  override def getAssets = Array[wcs.java.Asset](
    assets map { a =>
      a match {
        case x: CSElement =>
          new JCSElement(x.id, x.name, x.description, x.element)
        case x: Template =>
          new JTemplate(x.id, x.name, x.description, x.element, x.cscache, x.sscache)
        case x: SiteEntry =>
          new JSiteEntry(x.id, x.name, x.description, x.element, x.wrapper)
      }
    }: _*)

}