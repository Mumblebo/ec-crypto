package eccrypto;

import java.math.BigInteger;

import eccrypto.math.Corps;
import eccrypto.math.EllipticCurve;
import eccrypto.math.Point;

public class Main {

	// p=8884933102832021670310856601112383279507496491807071433260928721853918699951
	// n=8884933102832021670310856601112383279454437918059397120004264665392731659049
	// a4=2481513316835306518496091950488867366805208929993787063131352719741796616329
	// a6=4387305958586347890529260320831286139799795892409507048422786783411496715073
	// r4=5473953786136330929505372885864126123958065998198197694258492204115618878079
	// r6=5831273952509092555776116225688691072512584265972424782073602066621365105518
	// gx=7638166354848741333090176068286311479365713946232310129943505521094105356372
	// gy=762687367051975977761089912701686274060655281117983501949286086861823169994
	// r=8094458595770206542003150089514239385761983350496862878239630488323200271273

	public static void main(String[] args) {
		EllipticCurve curve = new EllipticCurve(new BigInteger("0"), new BigInteger("0"), new BigInteger("0"),
				new BigInteger("2481513316835306518496091950488867366805208929993787063131352719741796616329"),
				new BigInteger("4387305958586347890529260320831286139799795892409507048422786783411496715073"));

		Corps corps = new Corps(
				new BigInteger("8884933102832021670310856601112383279507496491807071433260928721853918699951"), curve);

		Point g = new Point(
				new BigInteger("7638166354848741333090176068286311479365713946232310129943505521094105356372"),
				new BigInteger("762687367051975977761089912701686274060655281117983501949286086861823169994"));
		System.out.println(corps.contain(g));
		
		Point p = corps.add(g, g);
		System.out.println(corps.contain(p));
		
		p = corps.mutiply(new BigInteger("1000"), g);
		System.out.println(corps.contain(p) + " " + p.x + "\n" + p.y);
		
		p = corps.oppose(g);
		System.out.println(corps.contain(p));
	}

}
