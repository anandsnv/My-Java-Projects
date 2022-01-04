using Microsoft.EntityFrameworkCore.Migrations;

namespace ResumeManager.Migrations
{
    public partial class ResumeUrl : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "ResumeUrl",
                table: "Applicants",
                type: "nvarchar(max)",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "ResumeUrl",
                table: "Applicants");
        }
    }
}
