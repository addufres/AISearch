package search;

public class Vertices {
	
	// FIELDS
	/**
	 * ID for the vertex
	 */
	final private String id;
	/**
	 * Name of the vertex
	 */
	final private String name;
	
	// CONSTRUCTORS
	/**
	 * Constructor for the Vertices class. 
	 * Constructs new Vertices object to use for search.
	 * 
	 * @param id of the vertex being constructed
	 * @param name of the vertex being constructed
	 */
	public Vertices(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// HASHCODE, EQUALS, TOSTRING
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertices other = (Vertices) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vertices [name=" + name + "]";
	}
	
	
}
