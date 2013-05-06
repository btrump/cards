package com.blairtrump.cards;

public enum LanguageBlock {
	FANTASY("for", "nam", "gli", "dar", "kut", "ban", "nor", "ex", "gep", "li",
			"fis", "ha", "ah", "re", "wer", "bap", "a", "e", "i", "o", "u", "y"), JAPANESE("a", "i", "u",
			"e", "o", "ya", "yu", "yo", "ka", "ki", "ku", "ke", "ko", "kya",
			"kyu", "kyo", "sa", "shi", "su", "se", "so", "sha", "shu", "sho",
			"ta", "chi", "tsu", "te", "to", "cha", "chu", "cho", "na", "ni",
			"nu", "ne", "no", "nya", "nyu", "nyo", "ha", "hi", "fuh", "he",
			"ho", "hya", "hyu", "hyo", "ma", "mi", "mu", "me", "mo", "mya",
			"myu", "myo", "ya", "yu", "yo", "ra", "ri", "ru", "re", "ro",
			"rya", "ryu", "ryo", "wa", "iwi", "ewe", "woo", "nnm", "ga", "gi",
			"gu", "ge", "go", "gya", "gyu", "gyo", "za", "jiz", "zu", "ze",
			"zo", "jaz", "juz", "joz", "da", "jid", "zud", "de", "do", "jad",
			"jud", "jod", "ba", "bi", "bu", "be", "bo", "bya", "byu", "byo",
			"pa", "pi", "pu", "pe", "po", "pya", "pyu", "pyo"), CHEROKEE("a",
			"e", "i", "o", "u", "v", "ga", "ka", "ge", "gi", "go", "gu", "gv",
			"ha", "he", "hi", "ho", "hu", "hv", "la", "le", "li", "lo", "lu",
			"lv", "ma", "me", "mi", "mo", "mu", "na", "hna", "nah", "ne", "ni",
			"no", "nu", "nv", "qua", "que", "qui", "quo", "quu", "quv", "s",
			"sa", "se", "si", "so", "su", "sv", "da", "ta", "de", "te", "di",
			"ti", "do", "du", "dv", "dla", "tla", "tle", "tli", "tlo", "tlu",
			"tlv", "tsa", "tse", "tsi", "tso", "tsu", "tsv", "wa", "we", "wi",
			"wo", "wu", "wv", "ya", "ye", "yi", "yo", "yu", "yv"), TENGWAR("t",
			"p", "kw", "nd", "mb", "ng", "th", "f", "khw",
			"nt", "mp", "nk", "nkw", "n", "m", "nw", "r", "v", "y", "w",
			"s", "a", "e", "i", "o", "u", "yy", "aa", "ee", "ii", "oo", "uu");
	String[] blocks;

	private LanguageBlock(String... blocks) {
		this.blocks = blocks;
	}

	public String[] getBlocks() {
		return this.blocks;
	}
}
