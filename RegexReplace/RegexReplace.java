public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("(\\d+)(cm|€)( |$)", "$1$3");
    }

    public static String obfuscateEmail(String s) {
        if (s == null || !s.contains("@")) {
            return s;
        }
        String[] parts = s.split("@", 2);
        String local = parts[0];
        String domain = parts[1];

        // Process local
        String obfuscatedLocal;
        int lastSepIndex = Math.max(local.lastIndexOf('.'), Math.max(local.lastIndexOf('-'), local.lastIndexOf('_')));
        if (lastSepIndex != -1) {
            String before = local.substring(0, lastSepIndex + 1);
            String after = local.substring(lastSepIndex + 1);
            String stars = "*".repeat(after.length());
            obfuscatedLocal = before + stars;
        } else {
            if (local.length() > 3) {
                obfuscatedLocal = local.substring(0, 3) + "*".repeat(local.length() - 3);
            } else {
                obfuscatedLocal = local;
            }
        }

        // Process domain
        String[] domainParts = domain.split("\\.");
        String obfuscatedDomain;
        if (domainParts.length == 3) {
            obfuscatedDomain = "*".repeat(domainParts[0].length()) + "." + domainParts[1] + "." + "*".repeat(domainParts[2].length());
        } else if (domainParts.length == 2) {
            String tld = domainParts[1];
            if ("com".equals(tld) || "org".equals(tld) || "net".equals(tld)) {
                obfuscatedDomain = "*".repeat(domainParts[0].length()) + "." + tld;
            } else {
                obfuscatedDomain = "*".repeat(domainParts[0].length()) + "." + "*".repeat(tld.length());
            }
        } else {
            // Fallback, but assume 2 or 3
            obfuscatedDomain = domain;
        }

        return obfuscatedLocal + "@" + obfuscatedDomain;
    }
}
