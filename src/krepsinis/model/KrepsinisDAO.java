package krepsinis.model;

import java.sql.*;

public class KrepsinisDAO {
        final static String URL = "jdbc:mysql://localhost:3306/krepsinis";
        public String add(Krepsinis krepsinis){
            String query = "insert into krepsinis (team_name, name_surname, league, sponsors, teams, user_id)" +
                    "values (?,?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection(URL, "root", "");
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, krepsinis.getTeamName());
                preparedStatement.setString(2, krepsinis.getNameSurname());
                preparedStatement.setString(3, krepsinis.getLeague());
                preparedStatement.setString(4, krepsinis.getSponsors());
                preparedStatement.setInt(5, krepsinis.getTeams());
                preparedStatement.setInt(6, krepsinis.getUserid());
                preparedStatement.executeUpdate();

                return "Successfully created new entry";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Failure creating new entry";
            }
        }

        public ResultSet searchByTeamName(String teamName, User user){
            String query2 = "";
            if (user.isAdmin()) { // display all results- it's admin after all ;)
                if (teamName.equals("")) {//Admin didn't entered any team_name - displaying all entries
                    query2 = "SELECT * FROM krepsinis";
                } else {// Admin entered team_name displaying specific entries
                    query2 = "SELECT * FROM krepsinis WHERE team_name LIKE '" + teamName + "'";
                }
            } else { // display only specific user results
                if (teamName.equals("")) {//User didn't entered any team_name - displaying all entries created by him
                    query2 = "SELECT * FROM krepsinis WHERE user_id = '" + user.getId() + "'";
                } else {// User entered team_name displaying specific entries created by him
                    query2 = "SELECT * FROM krepsinis WHERE user_id = '" + user.getId() + "' AND team_name LIKE '" + teamName + "'";
                }
            }

            ResultSet resultSet = null;
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                connection = DriverManager.getConnection(URL, "root", "");
                preparedStatement = connection.prepareStatement(query2);
                resultSet = preparedStatement.executeQuery(query2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultSet;
        }

        public void editById(Krepsinis krepsinis){
            String query = "update krepsinis set team_name=?, name_surname=?, league=?, sponsors=?, teams=? " +
                    " where id=?";
            try {
                Connection connection = DriverManager.getConnection(URL, "root", "");
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, krepsinis.getTeamName());
                preparedStatement.setString(2, krepsinis.getNameSurname());
                preparedStatement.setString(3, krepsinis.getLeague());
                preparedStatement.setString(4, krepsinis.getSponsors());
                preparedStatement.setInt(5, krepsinis.getTeams());
                preparedStatement.setInt(6, krepsinis.getId());
                preparedStatement.executeUpdate();

                System.out.println("succesful update current entry");
            } catch (SQLException e) {
                System.out.println("failure update current entry");
                e.printStackTrace();
            }
        }
        public void deleteById(int id){
            String query = "delete from krepsinis where id=?";
            try {
                Connection connection = DriverManager.getConnection(URL, "root", "");
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();

                System.out.println("succesful delete current entry");
            } catch (SQLException e) {
                System.out.println("failure delete current entry");
                e.printStackTrace();
            }
        }
}
