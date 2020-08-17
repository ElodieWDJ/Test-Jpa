/**
 * 
 */
package entity;

/**
 * @author perse
 * @Entity
 * @Table(name="livre")
 */
public class livre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;


}
