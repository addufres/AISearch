package search;

/**
 * @author dufresa
 *
 */
public class Vertices {
	
	// FIELDS
	/**
	 * ID for the vertex
	 */
	final private String ID;
	/**
	 * Name of the vertex
	 */
	final private String NAME;
	
	// CONSTRUCTORS
	/**
	 * Constructor for the Vertices class. 
	 * Constructs new Vertices object to use for search.
	 * 
	 * @param id of the vertex being constructed
	 * @param name of the vertex being constructed
	 */
	public Vertices(String id, String name) {
		this.ID = id;
		this.NAME = name;
	}

	// HASHCODE, EQUALS, TOSTRING
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
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
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vertices [name=" + NAME + "]";
	}
	
	
}
