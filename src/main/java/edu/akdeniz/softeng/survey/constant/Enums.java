
package edu.akdeniz.softeng.survey.constant;

/**
 * @author maemresen
 */
public class Enums {


    public enum Page {

        HOME("home", Constants.SurveyPageURL.HOME_PAGE_URI);
        private final String pageName;
        private final String pageURI;

        private Page(String pageName, String pageURI) {
            this.pageName = pageName;
            this.pageURI = pageURI;
        }

        public String getPageName() {
            return pageName;
        }

        public String getPageURI() {
            return pageURI;
        }

        public String getRedirectURI() {
            return getRedirectURI(pageURI);
        }

        public static String getRedirectURI(String pageURI) {
            return "redirect:" + pageURI;
        }

    }

}