package ova.model;

import java.io.Serializable;


/**
 * Model class representing a theme.
 */
public class Theme implements Serializable
{
	private String name;
	private String image;

	public Theme()
	{
	}

	public Theme(String name, String image)
	{
		this.name = name;
		this.image = image;
	}

	//~ Methods ----------------------------------------------------------------

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Theme theme = (Theme) o;

		if (name != null ? !name.equals(theme.name) : theme.name != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode()
	{
		return name != null ? name.hashCode() : 0;
	}
}
